
public class nodebaru {
    public nodebaru head = null;
    public nodebaru tail = null;

    public int data;
    public nodebaru next;

    public nodebaru(int d){
        this.data = d;
        this.next = null;
    }

    public void addfirst(int serahnamanya){
        nodebaru newnode = new nodebaru(serahnamanya);

        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            nodebaru isisementara = head;

            head = newnode;

            head.next = isisementara;
        }
    }

    public void addlast(int serahnamanya){
        nodebaru newnode = new nodebaru(serahnamanya);

        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    public void delete(int pos){
        if (pos == 0) {
            head = head.getnext();
            return;
        }

        nodebaru current = head;
        int count = 0;
        while (count < pos-1) {
            current = current.getnext();
            if (current == null){
                throw new IndexOutOfBoundsException("ga ketemu");
            }
            count++;
        }
        if (current.getnext()==null) {
            throw new IndexOutOfBoundsException("ga ketemu");  
        } 
        current.setnext(current.getnext().getnext());
    }

    public nodebaru(){
        this.getClass();
    }

    public String txt(){
        String output ="";
        nodebaru current = head;
        while (current != null) {
            output += current.getdata()+",";
            current = current.getnext();
        }

        return output;
    }

    public int getdata(){return data;}
    public nodebaru getnext(){return next;}

    public void setdata(int d){data = d;}
    public void setnext(nodebaru nx){next = nx;}
    
    public static void main(String[] args) {
        nodebaru nb = new nodebaru();
        nb.addfirst(6);
        nb.addfirst(1);
        nb.addfirst(5);
        nb.addfirst(3);
        nb.addlast(10);
        nb.addlast(15);

        System.out.println(nb.txt());

        nb.delete(3);
        System.out.println(nb.txt());
    }
}