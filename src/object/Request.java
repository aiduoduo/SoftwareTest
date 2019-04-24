package object;

import tools.Tool;

/**
 * Created by admin on 2019/4/23.
 */
public class Request {

    private int amount;
    private int[] informations;
    private String[] propertyNames;

    public Request() {
        init();
        amount = 0;
        propertyNames = Tool.getAllProperties();
        informations = new int[propertyNames.length];
    }

    //初始化信息数组
    private void init() {
        for (int i = 0; i < informations.length; i++) {
            informations[i] = -1;
        }

    }

    public String[] getPropertyNames() {
        return propertyNames;
    }

    public int[] getInformations() {
        return informations;
    }

    public boolean setAmount(int number) {
        if (number <= 0) {
            System.out.print("Request,number小于零");
            return false;
        }
        amount = number;
        return true;
    }

    //TODO:检查错误
    public boolean setInformation(String type, int[] information) {
        if (information.length != informations.length) {
            System.out.print("Request,information包含信息条数错误");
            return false;
        }
        informations = information;
        return true;
    }

    //判断请求信息是否正确
    public boolean isRight() {
        for (int information : informations) {
            if (information == -1)
                return false;
        }
        return true;
    }

    public int getAmount() {
        return amount;
    }

}
