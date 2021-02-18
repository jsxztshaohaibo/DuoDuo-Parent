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
