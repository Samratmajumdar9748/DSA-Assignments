import java.util.*;

public class CommonElementInMatrix {
    public static void printElementInAllRows(int mat[][]) {

        // Write code here

        Map<Integer,Integer> count= new HashMap<>();
        List<Integer> countList= new ArrayList<>();

        for (int i=0; i< mat[0].length; i++ ){
            count.put(mat[0][i],1);
        }

        for (int i=1; i< mat.length; i++){
            for (int j=0; j< mat[0].length; j++){

                if ( count.containsKey(mat[i][j]) && count.get(mat[i][j])==i){
                    count.put(mat[i][j],i+1);
                    if (i== mat.length-1 ){
                        countList.add(mat[i][j]);
                    }
                }

            }
        }

        Collections.sort(countList);

        for (int i: countList){
            System.out.print(i+ " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}
