import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by skoded001c on 8/29/16.
 */
public class RectangularCover {

    public boolean isRectangleCover(int[][] rectangles) {

        // convert rectangles into Point
        Map<Point, Set<Corner>> info = new HashMap<>();
        int minBot = Integer.MAX_VALUE;
        int maxTop = Integer.MIN_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;

        for (int[] rectangle : rectangles) {
            int bottom = rectangle[0];
            int left = rectangle[1];
            int top = rectangle[2];
            int right = rectangle[3];

            minBot = Math.min(minBot, bottom);
            maxTop = Math.max(maxTop, top);
            minLeft = Math.min(minLeft, left);
            maxRight = Math.max(maxRight, right);

            // check for overlapping rectangles while adding information about the current points
            boolean isValid = addInfo(info, new Point(bottom, left), Corner.BOTTOM_LEFT) &&
                    addInfo(info, new Point(bottom, right), Corner.BOTTOM_RIGHT) &&
                    addInfo(info, new Point(top, left), Corner.TOP_LEFT) &&
                    addInfo(info, new Point(top, right), Corner.TOP_RIGHT);

            if (!isValid) return false;
        }

        Set<Point> outerCorners = new HashSet<>();
        outerCorners.add(new Point(minBot, minLeft)); // bottom left corner
        outerCorners.add(new Point(minBot, maxRight)); // bottom right corner
        outerCorners.add(new Point(maxTop, minLeft)); // top left corner
        outerCorners.add(new Point(maxTop, maxRight)); // top right corner

        for (Map.Entry<Point, Set<Corner>> entry : info.entrySet()) {
            Set<Corner> corner = entry.getValue();
            if (corner.size() == 1 && outerCorners.contains(entry.getKey())) {
                outerCorners.remove(entry.getKey());
                continue;
            }
            if (!isValidCornerOverlap(corner)) return false;

        }

        return outerCorners.size() == 0;
    }

    private boolean addInfo(Map<Point, Set<Corner>> info, Point point, Corner corner) {
        if (info.containsKey(point)) {
            // check for overlaps
            if (info.get(point).contains(corner)) return false;
        } else {
            info.put(point, new HashSet<>());
        }

        info.get(point).add(corner);
        return true;
    }

    private boolean isValidCornerOverlap(final Set<Corner> corners) {
        return corners.size() == 4 ||
                (corners.size() == 2 && (corners.contains(Corner.TOP_RIGHT) && corners.contains(Corner.TOP_LEFT)) ||
                        (corners.contains(Corner.BOTTOM_RIGHT) && corners.contains(Corner.BOTTOM_LEFT)) ||
                        (corners.contains(Corner.BOTTOM_LEFT) && corners.contains(Corner.TOP_LEFT)) ||
                        (corners.contains(Corner.BOTTOM_RIGHT) && corners.contains(Corner.TOP_RIGHT)));
    }
}

enum Corner {
    TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
}

class Point {
    private int row;
    private int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}