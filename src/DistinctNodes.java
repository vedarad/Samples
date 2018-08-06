import java.util.*;

class DistinctNodes {

    static class Tree {
        int x;
        Tree l, r;

        Tree(int value) {
            this.x = value;
            l = r = null;
        }
    }

    static int solution(Tree T) {
        if(T == null){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int x =  distinctNodesPath(T, map);
        return x;
    }

    static int distinctNodesPath(Tree T, HashMap<Integer, Integer> map){

        if(T == null){
            return map.size();
        }

        if(!map.containsKey(T.x)){
            map.put(T.x, 1);
        }else{
            map.put(T.x, map.get(T.x) + 1);
        }
        
        int max_path = Math.max(distinctNodesPath(T.l, map),
                distinctNodesPath(T.r, map));

        map.put(T.x, map.get(T.x) - 1);

        if(map.get(T.x) == 0){
            map.remove(T.x);
        }

        return max_path;
    }

    public static void main(String args[]){
        
        Tree tree = new Tree(1);
        tree.l = new Tree(2);
        tree.l.l = new Tree(3);
        tree.l.r = new Tree(4);
        tree.l.r.l = new Tree(6);
        tree.r = new Tree(5);
        tree.r.r = new Tree(5);
        tree.r.l = new Tree(5);

        System.out.println(solution(tree));
    }
}
