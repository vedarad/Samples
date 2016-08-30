import java.util.ArrayList;
import java.util.List;

/**
 * Created by skoded001c on 8/30/16.
 */
public class ParkingSpotSolution {

    public static void main(String args[]){
        int[] carDimensions = {3, 2};
        int[][] parkingLot = {{1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1}};
        int[] luckySpot = {1, 1, 2, 3};
        System.out.println(parkingSpot(carDimensions, parkingLot, luckySpot));
    }

    static boolean is_left_entrance_clear(int[][] parkingLot, int[] luckySpot){
        List<Integer> list = new ArrayList<>();
        int x = luckySpot[0];
        int y = 0;
        while (x <= luckySpot[2]) {// on same row
            y = luckySpot[1]-1;
            while (y >= 0){
                list.add(x);
                list.add(y);
                y -= 1;
            }
            x += 1;
        }

        for(int k=0; k< list.size(); k+=2){
            if (parkingLot[list.get(k)][list.get(k+1)] == 1) return false;
        }
    return true;
}

    static boolean is_right_entrance_clear(int[][] parkingLot, int[] luckySpot){
        List<Integer> list = new ArrayList<>();
        int x = luckySpot[2];
        int y = 0;
        while (x < parkingLot[0].length){ // on same row
            y = luckySpot[3]+1;
            while (y < parkingLot[0].length){
                list.add(x);
                list.add(y);
                y += 1;
            }
            x += 1;
        }
        for(int k=0; k< list.size(); k+=2){
            if (parkingLot[list.get(k)][list.get(k+1)] == 1) return false;
        }
    return true;
}

    static boolean is_up_entrance_clear(int[][] parkingLot, int[] luckySpot){
        List<Integer> list = new ArrayList<>();
        int x = luckySpot[0]-1;
        int y = 0;
            while (x >= 0){ // on same row
                y = luckySpot[1];
                while (y <= luckySpot[3]){
                    list.add(x);
                    list.add(y);
                    y += 1;
                }
                x -= 1;
            }
        for(int k=0; k< list.size(); k+=2){
            if (parkingLot[list.get(k)][list.get(k+1)] == 1) return false;
        }
    return true;
}

    static boolean is_down_entrance_clear(int[][] parkingLot, int[] luckySpot){
        List<Integer> list = new ArrayList<>();
        int x = luckySpot[2]+1;
        int y = 0;
            while (x < parkingLot.length){ // on same row
                y = luckySpot[1];
                while (y <= luckySpot[3]){
                    list.add(x);
                    list.add(y);
                    y += 1;
                }
                x += 1;
            }
        for(int k=0; k< list.size(); k+=2){
            if (parkingLot[list.get(k)][list.get(k+1)] == 1) return false;
        }
    return true;
}

    static String define_spot_orientation(int[] luckySpot){
        if (Math.abs(luckySpot[1]-luckySpot[3]) > Math.abs(luckySpot[0]-luckySpot[2])) return "horizontal";
        else return "vertical";
    }


    static boolean is_entrance_exist(int[][] parkingLot, int[] luckySpot){
        if (define_spot_orientation(luckySpot) == "horizontal")
        return is_left_entrance_clear(parkingLot, luckySpot) || is_right_entrance_clear(parkingLot, luckySpot);
        else //spot orientation "vertical"
        return is_up_entrance_clear(parkingLot, luckySpot) || is_down_entrance_clear(parkingLot, luckySpot);
    }


    static boolean is_lucky_spot_empty(int[][] parkingLot, int[] luckySpot){
        int x = luckySpot[0];
        int y =0;
        while (x <= luckySpot[2]){
            y = luckySpot[1];
            while (y <= luckySpot[3]){
                if (parkingLot[x][y] == 1) return false;
                y += 1;
            }
            x += 1;
        }
        return true;
    }


    static boolean is_spot_fit_car(int[] carDimensions, int[] luckySpot){
            return (carDimensions[0] > luckySpot[2] - luckySpot[0] ||
                    carDimensions[1] > luckySpot[3] - luckySpot[1]);
    }


    static boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot){

        //does car fits in the spot
        if (!is_spot_fit_car(carDimensions, luckySpot)) return false;

        // does the spot is empty
        if (!is_lucky_spot_empty(parkingLot, luckySpot)) return false;

        //does a free entry large enough to the spot
        if (!is_entrance_exist(parkingLot, luckySpot)) return false;

        return true;
    }

}
