import java.util.Scanner;

class User_pro {
    private String accno;
    private String name;
    private String address;
    private String Mobile_no;
    int bal;
    Scanner s = new Scanner(System.in);

    public int getAccno() {
        return Integer.parseInt(accno);
    }

    public User_pro(int n) {
        System.out.println(n + " new accounts are created");
    }

    public User_pro() {
        System.out.println("A new bank account is being created");
    }

    public void register() {
        System.out.println("Enter account number");
        accno = s.next();
        System.out.println("Enter Name");
        name = s.next();
        System.out.println("Enter Address");
        address = s.next();
        System.out.println("Enter Mobile No");
        Mobile_no = s.next();
        System.out.println("Enter Balance");
        bal = Integer.parseInt(s.next());
    }

    public void accdetail() {
        System.out.println("Name     : " + name);
        System.out.println("Address  : " + address);
        System.out.println("Mobile No : " + Mobile_no);
        System.out.println("Balance  : " + bal);
    }

    public void DepBal(int bal) {
        this.bal = this.bal + bal;
        System.out.println("Balance is " + this.bal);
    }

    public void withdrawBal(int bal) {
        int x = this.bal;
        this.bal = this.bal - bal;
        if (this.bal >= 0) {
            System.out.println("Balance is " + this.bal);
        } else {
            System.out.println("Insufficient Balance!!");
            this.bal = x;
        }
    }

    public void showbal() {
        System.out.println("The balance is " + bal);
    }

    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
        System.out.println("New Mobile Number is " + Mobile_no);
    }
}

class Bank {
    public static void main(String[] args) {
        System.out.println("Enter the No of Accounts: ");
        Scanner c = new Scanner(System.in);
        int n = c.nextInt();
        User_pro A[] = new User_pro[n];
        for (int i = 0; i < n; i++) {
            A[i] = new User_pro();
            A[i].register();
        }
        System.out.println("Enter Account No:");
        int input = c.nextInt();
        int flag = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (A[i].getAccno() == input) {
                flag = 1;
                j = i;
                break;
            }
        }

        if (flag == 1) {
            int q;
            do {
                System.out.println("1: View Customer Data");
                System.out.println("2: Deposit Money");
                System.out.println("3: Withdraw Money");
                System.out.println("4: Update Mobile No");
                System.out.println("Choose an Option (1-4)");
                q = c.nextInt();

                switch (q) {
                    case 1:
                        System.out.println("Customer Data:");
                        A[j].accdetail();
                        break;
                    case 2:
                        System.out.println("Enter Amount to Deposit:");
                        Scanner dep = new Scanner(System.in);
                        int depp = dep.nextInt();
                        A[j].DepBal(depp);
                        break;
                    case 3:
                        System.out.println("Enter Amount to Withdraw:");
                        Scanner wit = new Scanner(System.in);
                        int witt = wit.nextInt();
                        A[j].withdrawBal(witt);
                        break;
                    case 4:
                        System.out.println("Enter New Mobile No:");
                        Scanner num = new Scanner(System.in);
                        String numb = num.next();
                        A[j].setMobile_no(numb);
                        break;
                }
            } while (q != 5);

        } else {
            System.out.println("No Account Found");
        }
        c.close();
    }
}
