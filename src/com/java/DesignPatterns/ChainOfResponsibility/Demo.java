package com.java.DesignPatterns.ChainOfResponsibility;

enum LogLevel { INFO, DEBUG, ERROR, WARN };

// This is the abstract handler class
abstract class Logger{
	// it has the reference to the next handler
	Logger nextLogger;
	
	Logger(Logger logger){
		this.nextLogger = logger;
	}
	
	// common implementation for all the derived classes
	public void log( LogLevel level, String message ) {
		if( this.nextLogger != null) {
			this.nextLogger.log(level, message);
		}
	}
}

// Concrete handler
class InfoLogger extends Logger{
	
	public InfoLogger( Logger logger ) {
		super(logger);
	}
	
	@Override
	public void log( LogLevel level, String message  ) {
		// If the request is for this handler then handle
		if( level == LogLevel.INFO ) {
			System.out.println("INFO: "+ message);
		}else {
			// else pass it to the next handler
			super.log(level, message);
		}
	}
}

// Similar concrete handler
class DebugLogger extends Logger{
	
	public DebugLogger( Logger logger ) {
		super(logger);
	}
	
	@Override
	public void log( LogLevel level, String message  ) {
		if( level == LogLevel.DEBUG ) {
			System.out.println("DEBUG: "+ message);
		}else {
			super.log(level, message);
		}
	}
}

class ErrorLogger extends Logger{
	
	public ErrorLogger( Logger logger ) {
		super(logger);
	}
	
	@Override
	public void log( LogLevel level, String message  ) {
		if( level == LogLevel.ERROR ) {
			System.out.println("ERROR: "+ message);
		}else {
			super.log(level, message);
		}
	}
}


public class Demo {

	public static void main(String[] args) {
		
		// Creates the chain of handlers
		Logger loggerChain = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
		
		// User can use the chain and has not to worry about the specific handler
		loggerChain.log(LogLevel.ERROR, "Finally it is an error!");
		
		loggerChain.log(LogLevel.INFO, "This is an information!");
		
		loggerChain.log(LogLevel.DEBUG, "This is a debug!");
		

	}

}
