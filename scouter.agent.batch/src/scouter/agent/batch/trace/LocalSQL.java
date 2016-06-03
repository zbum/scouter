package scouter.agent.batch.trace;

public class LocalSQL extends java.util.HashMap<Integer, TraceSQL>{
	private static final long serialVersionUID = 1L;
	private String threadName;
	private TraceSQL currentTraceSql;
	
	public LocalSQL() {
		super(100);
		this.threadName = Thread.currentThread().getName();
	}
	
	public TraceSQL get(String sqlText){
		int hashValue = sqlText.hashCode();
		TraceSQL traceSql = super.get(hashValue);
		if(traceSql == null){
			hashValue = TraceContext.getInstance().getSQLHash(sqlText, hashValue);
			
			traceSql = new TraceSQL();
			traceSql.hashValue = hashValue;
			super.put(hashValue, traceSql);
		}
		currentTraceSql = traceSql;
		return traceSql;
	}
	
	public TraceSQL getCurrentTraceSQL(){
		return currentTraceSql;
	}
	
	public String toString(){
		return threadName + ": " + super.toString();
	}
}
