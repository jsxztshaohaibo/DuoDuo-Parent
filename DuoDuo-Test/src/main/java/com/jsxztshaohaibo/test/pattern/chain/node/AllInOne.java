package com.jsxztshaohaibo.test.pattern.chain.node;

/***
 *  
 * @author Administrator
 *
 */
public class AllInOne {
	
	private  String name;
    private  AllInOne next;
    private  Integer leaveDays;
   

	public AllInOne(String name, Integer leaveDays) {
		super();
		this.name = name;
		this.leaveDays = leaveDays;
	}



	//处理请求的方法
    public  void handleRequest(int LeaveDays){
    	 if (LeaveDays <= leaveDays) {
             System.out.println(this.getName()+"批准您请假" + LeaveDays + "天。");
         } else {
         	
         	System.out.println("---------------");
         	System.out.println("请假 超过" + LeaveDays + "天，"+this.getName()+"已无权审批，需要下一审批人进行审批。");
             if (getNext() != null) {
                 getNext().handleRequest(LeaveDays);
             } else {
                 System.out.println("请假天数太多，没有人批准该假条！");
             }
             System.out.println("---------------");
         }    	
    }
	
    
    
    public void setNext(AllInOne next) {
        this.next = next;
    }
    public AllInOne getNext() {
        return next;
    }
    
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the leaveDays
	 */
	public Integer getLeaveDays() {
		return leaveDays;
	}



	/**
	 * @param leaveDays the leaveDays to set
	 */
	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
	}
}