import java.util.*;

public class HashingAndProbingPractice {
    public static void main(String[]args){
    Scanner input = new Scanner(System.in);

    boolean comp = true;
    while(comp){
    int numOfVarInTable = 0;
    System.out.print("Set Table Size: ");
    int tablesize = input.nextInt();
    HashingAndProbingMethods hpm = new HashingAndProbingMethods();
    hpm.HashTableAndProbingMethods(tablesize);
    Hashtable hashtable = new Hashtable<>(tablesize);
    System.out.printf("Choose Your Hashing Algorithm\n1: DirectHashing\n2: SubtractionHashing \n3: DigitExtractionHashing\n4: ModDivisionHashing\n5: MidSquareHashing\n6: FMFoldShift\n7: FMFoldBoundary\nOption: ");
    int optionHashing = input.nextInt();
    System.out.printf("Choose Your Probing Algoritm\n1: DirectProbing\n2: QuadraticProbing\n3: KeyOffest\nOption: ");
    int optionProbing = input.nextInt();
    int constant = 0;
        switch(optionHashing){
            case 2: System.out.print("Input Constant: ");
            constant = input.nextInt();break;
            case 3: System.out.print("Input digit number: ");
            constant = input.nextInt();break;
            case 6: System.out.print(" Input digits per chunk: ");
            constant = input.nextInt();break;
            case 7: System.out.print(" Input boundary after every digit number: ");
            constant = input.nextInt();break;
        }
    System.out.print("Input Contents in the Table? Y/N\n Option: ");
    String contentYN = input.next();
    if(contentYN.equalsIgnoreCase("Y")){
        System.out.printf("How many contents will you put? (Available inputs "+(tablesize-numOfVarInTable)+"): \nInput: ");
        int numOfInputs = input.nextInt();
        if(numOfVarInTable < tablesize ){
            int addToTable = 0;
        for(int i=0; i<numOfInputs-numOfVarInTable; i++){
            System.out.print("Input integer "+(i+1)+": ");
            int key = input.nextInt();
            hpm.insert(key, optionHashing, optionProbing, constant);
            addToTable++;
        }
        numOfVarInTable = numOfVarInTable+addToTable;
    }
    else {
        System.out.println("Table is full cannot add more Elements");
    }
    }
    boolean newcomp = true;
    while(newcomp){
    System.out.printf("Choose an Option\n1: Display Table\n2: Clear Table\n3: Delete an Index\n4: Add Element/s\n5: New Insertions\n6: Exit\nOption: ");
    int optionMain = input.nextInt();
    if(optionMain == 1){
        hpm.displayTable();
        continue;
    }else if(optionMain == 2){
        hpm.clearTable(); 
        System.out.println("Table Cleared");
        numOfVarInTable = 0;
        continue;
    }else if(optionMain == 3){
        System.out.print("Input index to remove: "); 
        int remIndex = input.nextInt(); hpm.removeAtIndex(remIndex); 
        System.out.println("Index "+remIndex+" removed!"); 
        numOfVarInTable--;
        continue;
    }else if(optionMain == 4){
        System.out.printf("How many contents will you put? (Available inputs %d): \nInput: ", (tablesize - numOfVarInTable));
                int numOfInputsAdd = input.nextInt();
                    if (numOfVarInTable < tablesize) {
                    int addToTable = 0; 
                    for (int i = 0; i < Math.min(numOfInputsAdd, tablesize - numOfVarInTable); i++) {
                        System.out.print("Input integer " + (i + 1) + ": ");
                        int key = input.nextInt();
                        hpm.insert(key, optionHashing, optionProbing, constant);
                        addToTable++;
                    }
                    numOfVarInTable += addToTable;
                } else {
                    System.out.println("Table is full; cannot add more elements");
                }
                continue;
    }else if(optionMain == 5){
        newcomp = false;
        comp = true;
    }else if(optionMain == 6){
        System.out.println("Exiting Program"); 
        System.exit(6);
    }
}
}
}}

 