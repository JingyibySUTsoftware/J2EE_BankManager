## BankManager
### JavaWeb快速入门的J2EE项目
### 项目简介
#### 技术栈  Servlet + Jsp + Tomcat比较适合新手入门练手
>项目用到的技术如下：
>Java：`Java SE基础` 
>前端： `HTML` , `CSS` , `JavaScript` , `jQuery` `LayUI（前端模板框架）`
>J2EE： `Tomcat` , `Servlet` , `JSP` , `Filter`
>数据库： `MySQL`

----
#### 业务需求
后台管理页
1.管理员登录
	1.1 新增用户信息
	1.2 新增银行卡信息
	1.3 修改银行卡信息
  	1.4 删除银行卡
 	1.5 查看所有银行卡信息
 	1.6 根据条件查看银行卡信息
前台用户页
 2.用户登录
 	 2.1 取钱功能
	 2.2 存钱功能
	 2.3 转账功能
	 2.4 查看自己银行卡信息
	 2.5 修改密码功能

----
#### 表结构
| 表名        | 中文含义   | 介绍                                             |
| ----------- | ---------- | ------------------------------------------------ |
| bankcard    | 银行卡表   | 存放银行卡信息如卡号，密码，余额，卡类型，用户号 |
| bankmanager | 管理员表   | 存放管理员信息如管理员号，管理员姓名，管理员密码 |
| bankuser    | 用户信息表 | 存放用户信息如用户id，用户名，手机，公司，籍贯   |

----
本文主要以用户表为例查询用户信息为示例功能演示
J2EE的核心思想
#### 实体类（bean包下）
实体类就是基于ORM（Object Relational Mapping）思想，将Java的类与数据库的表进行映射
BankUser.java映射bankuser表

```java
/**   
 * @ClassName:  BankUser   
 * @Description:用户实体类
 * @author: jingyi
 * @date:   2021年5月10日 下午4:18:14      
 * @Copyright:  
 */
public class BankUser {
	private int uid;//用户id
	private String uname;//用户名
	private int uphone;//电话
	private String company;//公司
	private String hometown;//籍贯
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUphone() {
		return uphone;
	}
	public void setUphone(int uphone) {
		this.uphone = uphone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
```
数据库bankuser表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210708201618333.png)

----
#### Dao层（dao包下）
用于进行数据库访问的操作
那么在访问数据库之前我们需要借助数据库连接池

使用数据库连接工具类帮助我们获取数据库连接对象，关闭数据库连接对象  
connUtil.java

```java
public class connUtil {
	private static ThreadLocal<Connection> threadload=new ThreadLocal<>();
	private static DataSource ds;
	static {//数据源对象加载
		try {
			Properties properties = new Properties();
			InputStream ins=connUtil.class.getResourceAsStream("/mysql.properties");
			properties.load(ins);
			ds=BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获取数据库连接对象
	public static Connection getConn() throws SQLException{
		Connection conn=threadload.get();
		if(conn==null||conn.isClosed()) {
			conn=ds.getConnection();
			threadload.set(conn);
		}
		return conn;
	}
	
	//关闭数据库连接对象
	public static void closeConn() {
		Connection conn=threadload.get();
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			threadload.set(conn);
		}
	}
}
```

这里还需要一个资源文件用来告知工具类我们需要连接哪个数据库
mysql.proprerties

```xml
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/class04?characterEncoding=utf8&serverTimezone=Asia/Shanghai
username=root
password=root
maxActive=30
maxIdle=10
maxWait=60000
```
创建BankDao接口，这里不使用一个类直接操作数据库，而是使用接口声明方法，再用这个接口的实现类去操作数据库，这样可以降低层与层之间的耦合度
BankDao.java

```java
public interface BankDao {
	public List<BankUser> FindAllUser() throws SQLException;
}
```
BankDaoImpl.java（dao.Impl包下）
对于不同的功能对应不同的方法与数据库进行数据操作
```java
public class BankDaoImpl implements BankDao {

	@Override
	public List<BankUser> FindAllUser() throws SQLException {	
		Connection conn = connUtil.getConn();
		String sql="select * from  bankuser";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<BankUser> list =new ArrayList<BankUser>();
		while(rs.next()) {
			BankUser user = new BankUser();
			user.setUid(rs.getInt(1));
			user.setUname(rs.getString(2));
			user.setUphone(rs.getInt(3));
			user.setCompany(rs.getString(4));
			user.setHometown(rs.getString(5));
			list.add(user);
		}
		return list;
	}
}
```
----
#### Service层（service包下）
与controller层直接通信，进一步降低层之间的耦合性
BankService.java
```java
public interface BankService {
	public List<BankUser> FindAllUser();
}	
```

数据结果的判断，事物的提交、回滚都在这里进行处理
BankServiceImpl.java（service.Impl包下）

```java
public class BankServiceImpl implements BankService {
	BankDao bankdao=new BankDaoImpl();
	@Override
	public List<BankUser> FindAllUser() {
		List<BankUser> list=null;
		try {
			list=bankdao.FindAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connUtil.closeConn();
		}
		return list;
	}
}	
```
----
#### Controller层（controller包下）
当前台页面发出请求，最先会通过过滤器，过滤器会首先判断系统是否用角色登录，如果已经登录则转发该请求到controller层，由@WebServlet注解选择对应的servlet进行处理
AddCardServlet.java
```java
@WebServlet("/addcard")
public class AddCardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BankService bankService = new BankServiceImpl();
		BankCard card=new BankCard();
		BankUser user = new BankUser();
		card.setBankuser(user);
		card.setCpssword(Integer.valueOf(req.getParameter("password")));
		card.setCmoney(Double.valueOf(req.getParameter("cmoney")));
		card.setCtype(req.getParameter("ctype"));
		card.getBankuser().setUid(Integer.valueOf(req.getParameter("ID")));
		boolean flag=bankService.AddCard(card);
		if(flag) {
			if(flag) {
				resp.sendRedirect("toaddcard");
			}else {
				resp.sendRedirect("jsp/addcardError.jsp");
			}
		}
	}
}

```
----
#### 核心思想
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210708210309150.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDUyNDY4Nw==,size_16,color_FFFFFF,t_70)
#### Filter
过滤器主要功能
1.拦截所有请求
2. 判断是否登录
3. 已登陆发送的请求则通过并转发
4. 未登录发送的请求则跳转到登录页

MyFilter.java
```java
@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String uri=req.getRequestURI();
		if(uri.endsWith("Login.jsp")||uri.endsWith("login")||uri.endsWith("checkaccount")||uri.contains(".css") || uri.contains(".js") || uri.contains(".png")|| uri.contains(".jpg")) {//如果为登录请求
			chain.doFilter(request, response);
		}else {//不是去登录页面或登录请求
			String uname=(String)req.getSession().getAttribute("uname");
			String mname=(String)req.getSession().getAttribute("mname");
			if(uname!=null||mname!=null) {//管理员或者用户已登录
				chain.doFilter(request, response);
			}else{
				req.getSession().setAttribute("Needloginmsg", "something");
				resp.sendRedirect("Login.jsp");			
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
```



#### 部分页面演示
页面主要使用Layui前端模板框架编写，详细使用可参考[layui官网](https://www.layui.com/)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210708210823639.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDUyNDY4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210708210958271.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDUyNDY4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210708211107458.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDUyNDY4Nw==,size_16,color_FFFFFF,t_70)