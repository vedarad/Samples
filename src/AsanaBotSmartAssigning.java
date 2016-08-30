/**
 * Created by skoded001c on 8/30/16.
 */
public class AsanaBotSmartAssigning {

    String smartAssigning(String[][] information) {

        String t = null;

        if(information.length < 1)
            return t;

        if(information.length == 1){
            t = information[0][0];
            return t;
        }

        if(information.length>1){
            for(int i=0; i<information.length; i++){
                String[] inner = information[i];
                for(int j = i+1; j < information.length; j++){
                    String[] subinner = information[j];

                    if(Integer.parseInt(inner[1]) == Integer.parseInt(subinner[1])){
                        if(Integer.parseInt(inner[3]) > Integer.parseInt(subinner[3])){
                            t= subinner[0];
                        }else if(Integer.parseInt(inner[3]) < Integer.parseInt(subinner[3])){
                            t= inner[0];
                        }else{
                            if(Integer.parseInt(inner[2]) < Integer.parseInt(subinner[2])){
                                t= inner[0];
                            }else if(Integer.parseInt(inner[2]) > Integer.parseInt(subinner[2])){
                                t= subinner[0];
                            }
                        }
                    }else if(Integer.parseInt(inner[1]) > Integer.parseInt(subinner[1])){
                        t= inner[0];
                    }else if(Integer.parseInt(inner[1]) < Integer.parseInt(subinner[1])){
                        t= subinner[0];
                    }

                }
            }
        }


        return t;
    }
}
