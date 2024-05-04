package com.java.DesignPatterns.TemplateDP;

// Copied from here: https://github.com/anuva04/SystemDesign/blob/main/DesignPatterns/BehavioralPatterns/TemplatePattern.java


public class Demo {

	public static void main(String[] args) {
        FunctionAppPipeline functionAppPipeline = new FunctionAppPipeline();
        functionAppPipeline.runPipeline();
        
        System.out.println("******************************************");
        
        WebappPipeline webappPipeline = new WebappPipeline();
        webappPipeline.runPipeline();
	}

}

abstract class CICDPipeline {
    public void runPipeline() {
        checkout();
        build();
        runTests();
        runComplianceChecks();
        deploy();
    }
    protected void checkout() {
        System.out.println("Checking out code...");
        System.out.println("Checked out code.");
    }

    protected abstract void build();
    protected abstract void runTests();

    protected void runComplianceChecks() {
        System.out.println("Running compliance checks...");
        System.out.println("Compliance checked cleared.");
    }

    protected abstract void deploy();
}

class FunctionAppPipeline extends CICDPipeline {
    @Override
    protected void build() {
        System.out.println("Building functionapp code...");
        System.out.println("Functionapp code built.");
    }

    @Override
    protected void runTests() {
        System.out.println("Running functionapp tests...");
        System.out.println("Tests cleared.");
    }

    @Override
    protected void deploy() {
        System.out.println("Deploying code to functionapp slot...");
        System.out.println("Deployed code to functionapp slot.");
    }
}

class WebappPipeline extends CICDPipeline {
    @Override
    protected void build() {
        System.out.println("Building webapp code...");
        System.out.println("Webapp code built.");
    }

    @Override
    protected void runTests() {
        System.out.println("Running webapp tests...");
        System.out.println("Tests cleared.");
    }

    @Override
    protected void deploy() {
        System.out.println("Deploying code to webapp slot...");
        System.out.println("Deployed code to webapp slot.");
    }
}
