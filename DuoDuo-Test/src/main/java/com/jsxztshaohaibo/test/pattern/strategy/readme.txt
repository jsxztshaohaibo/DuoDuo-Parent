策略模式的优缺点


备注：
    责任链与策略模式有很多相似之处，如都是行为型设计模式，都能够处理代码中的if-else逻辑
    主要区别在于:
    
    责任链 封装了算法，通过上下文对象去接受客户端的数据，根据数据类型执行不同的算法
    
    策略模式的客户端知道所有算法以及各种算法的区别



优点：
	1.策略模式符合开闭原则。
	2.避免使用多重条件转移语句，如 if...else...语句、switch 语句
	3.使用策略模式可以提高算法的保密性和安全性。

缺点：
			1.客户端必须知道所有的策略，并且自行决定使用哪一个策略类。
			2.代码中会产生非常多策略类，增加维护难度(可以使用享元模式来减少对象的数量)。
			
2. spring + 简单工厂模式 +  策略模式   优化 多余的if...else  （见代码）

   @Order(3)  注解 可以指定List 集合中 工具类 的注入的顺序
   
   
1. 简单工厂模式   +  策略模式    优化 多余的if...else

       *******可以单例模式创建工厂类
		定义一个短信渠道的接口 SmsChannelService，所有的短信渠道API都实现该接口；
			短信渠道接口 SmsChannelService.java
			public interface SmsChannelService{
				//发送短信
				void send(String phoneNo,String content);
			}
			
			短信渠道A SmsChannelServiceImplA.java
			public class SmsChannelServiceImplA implements SmsChannelService {
				public void send(String phoneNo, String content) {
					System.out.println("通过短信渠道A发送短信");
				}
			}
			
			短信渠道B SmsChannelServiceImplB.java
			public class SmsChannelServiceImplB implements SmsChannelService {
				public void send(String phoneNo, String content) {
					System.out.println("通过短信渠道B发送短信");
				}
			}
			
			通过工厂类来初始化所有短信渠道SmsChannelFactory.java
			public class SmsChannelFactory {
				private Map<String,SmsChannelService> serviceMap;
				//初始化工厂，将所有的短信渠道Service放入Map中
				public SmsChannelFactory(){
					//渠道类型为 key , 对应的服务类为value ：
					serviceMap=new HashMap<String, SmsChannelService>(2);
					serviceMap.put("CHANNEL_A",new SmsChannelServiceImplA());
					serviceMap.put("CHANNEL_B",new SmsChannelServiceImplB());
				}
			
				//根据短信渠道类型获得对应渠道的Service
				public SmsChannelService buildService(String channelType){
					return serviceMap.get(channelType);
				}
			}
			public class SmsSendService {
				private SmsChannelFactory smsChannelFactory;
				public SmsSendService(){
					smsChannelFactory=new SmsChannelFactory();
				}
				public void send(String phoneNo,String content){
					//从配置中读取 短信渠道
					String channelType=config.getChannelType();
					//获取渠道类型对应的服务类
					SmsChannelService channelService=smsChannelFactory.buildService(channelType);
					//发送短信
					channelService.send(phoneNo,content);
				}
			
			}

							这样SmsSendService类非常简洁，把“if else"干掉了，
							如果我要增加一个短信渠道C，无需再次更改 SmsSendService 类。
							1.只需要增加一个类 SmsChannelServiceImplC 实现 SmsChannelService 接口，
							2.然后在工厂类 SmsChannelFactory 中增加一行初始化 SmsChannelServiceImplC 的代码即可。
							
							增加短信渠道C的实现 SmsChannelServiceImplC.java
							public class SmsChannelServiceImplC implements SmsChannelService {
								public void send(String phoneNo, String content) {
									System.out.println("通过短信渠道C发送短信");
								}
							}
							修改工厂类 SmsChannelFactory.java
							public class SmsChannelFactory {
								private Map<String,SmsChannelService> serviceMap;
								//初始化 serviceMap ，将所有的短信渠道Service放入Map中
								public SmsChannelFactory(){
									//渠道类型为 key , 对应的服务类为value ：
									serviceMap=new HashMap<String, SmsChannelService>(3);
									serviceMap.put("CHANNEL_A",new SmsChannelServiceImplA());
									serviceMap.put("CHANNEL_B",new SmsChannelServiceImplB());
									//ADD 增加一行 SmsChannelServiceImplC 的初始化代码 
									serviceMap.put("CHANNEL_C",new SmsChannelServiceImplC());
								}
								//根据渠道类型构建短信渠道Service
								public SmsChannelService buildService(String channelType){
									return serviceMap.get(channelType);
								}
							}
		

2. spring + 简单工厂模式 +  策略模式   优化 多余的if...else  （见代码）
