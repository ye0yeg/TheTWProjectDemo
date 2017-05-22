package gp.ye0yeg.thetwprojectdemo.utils;

/**
 * Created by Administrator on 5/22/2017.
 */

public class FootCal {

    private int footHeight;
    private int footWidth;
    private int height;

//
//    FootCal(int footHeight, int footWidth, int height) {
//        this.footHeight = footHeight;
//        this.footWidth = footWidth;
//        this.height = height;
//    }

    public static int calFootRatio(int footHeight, int footWidth) {
        int calRadio;
        float footRatio = (float) footHeight / (float) footWidth;

        if (footRatio < 2.2) {
//            countSmall++;  Small的情况
            calRadio = 0;
        } else if (footRatio > 3.2) {
//            countBig++;  Big的情况
            calRadio = 2;
        } else {
//            countNormal++;  Normal的情况
            calRadio = 1;
        }
        return calRadio;
    }

    public static int calFootHeight(int height) {
        int calHeight;
        //height 的取值范围为10-20之间
        if (height < 12) {
            //低
            calHeight = 0;
        } else if (height > 18) {
            //高
            calHeight = 2;
        } else {
            //Normal
            calHeight = 1;
        }
        return calHeight;
    }

    /*
    * @param radio 为比例固定值 , 0 ,1 ,2
    * */
    public static String calResult(int radio, int height) {
        String result = "";
        int resultCode = 0;
        if (radio == 0 && height == 0) {
            result = "足小，扁平";
            resultCode = 0;
        } else if (radio == 1 && height == 0) {
            result ="足正常，扁平";
        } else if(radio ==2 && height ==0){
            result ="足大，扁平";
        } else if(radio==0&&height==1){
            result ="足小，足高正常";
        } else if(radio ==1 && height==1){
            result ="足正常，足高正常";
        } else if(radio ==2 && height ==1){
            result ="足大，足高正常";
        } else if(radio==0 && height==2){
            result ="足小，足高偏高";
        } else if(radio ==2 && height==2){
            result ="足正常，足高偏高";
        }else{
            result="足大，足高偏高";
        }
        return result;
    }
}
