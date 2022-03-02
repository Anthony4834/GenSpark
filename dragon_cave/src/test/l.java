public class AddOneToArrayList implements Assignment {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> main(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓

        ArrayList<Integer> output = new ArrayList<>();

        String numToString = "";

        for(int i = 0; i < list.size(); i++) {
            numToString = numToString + list.get(i);
        }

        int num = Integer.parseInt(numToString);
        num++;

        for(char c : String.valueOf(num).toCharArray()) {
            output.add(Integer.valueOf(c));
        }
        return output;
    }
}

AddOneToArrayList e = new AddOneToArrayList();

ArrayList<Integer> test = new ArrayList<>();
test.add(1);
test.add(2);
