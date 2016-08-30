/**
 * Created by skoded001c on 8/30/16.
 */
public class FareEstimator {

    double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {

        if(ride_time==0 || ride_distance==0 || cost_per_minute.length==0 ||
                cost_per_mile.length==0)
            return new double[] {0};

        double[] fareEst = new double[cost_per_minute.length];
        double price = 0;
        for(int i=0; i<cost_per_mile.length;i++){
            fareEst[i] = cost_per_mile[i] * ride_distance;
        }

        for(int i=0; i<cost_per_minute.length;i++){
            fareEst[i] = fareEst[i] + (cost_per_minute[i] * ride_time);
        }

        return fareEst;
    }

}
