import java.util.Scanner;
class User_pro{
    private String accno;
    private String name;
    private String address;
    private String Mobile_no;
    int bal;
    Scanner s=new Scanner(System.in);

    public int getAccno() {
        return Integer.parseInt(accno);
    }

    public User_pro(int n) {
        System.out.println(n+" new accounts are created");
    }
    public User_pro(){
        System.out.println("A new bank account is being created");
    }
    public void User_pro(){
        System.out.println("Enter account number");
        accno = s.next();
        System.out.println("enter the name");
        name=s.next();
        System.out.println("enter address");
        address=s.next();
        System.out.println("enter mobile no");
        Mobile_no=s.next();
        System.out.println("enter balance");
        bal= Integer.parseInt(s.next());
    }
    public void accdetail(){
        System.out.println("name     : "+name);
        System.out.println("address  : "+address);
        System.out.println("Mobileno : "+Mobile_no);
        System.out.println("Balance  : "+bal);
    }

    public void DepBal(int bal) {
        this.bal = this.bal+bal;
        System.out.println("bal is "+this.bal);
    }
    public void withdrawBal(int bal) {
        int x=this.bal;
        this.bal = this.bal-bal;
        if (this.bal >= 0) {
        System.out.println("bal is "+this.bal);
        }
        else {
            System.out.println("insufficient balance");
            this.bal=x;
        }
    }

    public void showbal(){
        System.out.println("THe balance is "+bal);
    }

    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
        System.out.println("new mobile number is "+Mobile_no);
    }
}
class Bank{
    public static void main(String[] args) {
        System.out.println("enter the no of accounts");
        Scanner c = new Scanner(System.in);
        int n= c.nextInt();
        User_pro A[]= new User_pro[n];
        for (int i = 0; i < n; i++) {
            A[i]=new User_pro();
            A[i].User_pro();
        }
        System.out.println("give accno");
        Scanner accscn=new Scanner(System.in);
        int trail=accscn.nextInt();
        int flag=0;
        int j=0;
        for (int i = 0; i < n; i++) {
            if (A[i].getAccno()==trail){
                flag=1;
                j=i;
                break;
            }
        }

        if(flag==1) {
            int q;
            do {
                System.out.println("1st choice customer data");
                System.out.println("2nd choice deposit");
                System.out.println("3rd choice withdraw");
                System.out.println("4th choice Update Mob.Num");
                System.out.println("enter your choice");
                Scanner ch = new Scanner(System.in);

                q = ch.nextInt();

                switch (q) {
                    case 1:
                        System.out.println("customer data");
                        A[j].accdetail();
                        break;
                    case 2:
                        System.out.println("enter bal deposit");
                        Scanner dep = new Scanner(System.in);
                        int depp = dep.nextInt();
                        A[j].DepBal(depp);
                        break;
                    case 3:
                        System.out.println("withdraw balance amount");
                        Scanner wit = new Scanner(System.in);
                        int witt = wit.nextInt();
                        A[j].withdrawBal(witt);
                        break;
                    case 4:
                        System.out.println("enter new mobile no");
                        Scanner num = new Scanner(System.in);
                        String numb = num.next();
                        A[j].setMobile_no(numb);
                        break;
                }
            } while (q != 5);

        }
        else {
            System.out.println("No such account");
        }
    }
}
