public class ReduceTheCodeTester
{

    public ReduceTheCodeTester()
    {
    }

    public static void testReduceTheCode()
    {
        System.out.println("Starting the tester");
        ReduceTheCode r1 = new ReduceTheCode();
        ReduceTheCode r2 = new ReduceTheCode();
        boolean getFooError = false;
        for(int i = 0; i < 1000; i++)
        {
            ReduceTheCode tmp = new ReduceTheCode();
            if(tmp.getFoo() != 5 && !getFooError)
            {
                getFooError = true;
                System.out.println("Error with getFoo");
            }
        }

        boolean setVariablesWorks = true;
        int i;
        for(i = 0; i < 30; i++)
        {
            int num1 = (int)(Math.random() * 1000D);
            int num2 = (int)(Math.random() * 1000D);
            r1.setVariables(num1);
            r2.setVariables(num2);
            if(setVariablesWorks && (r1.getFoo() != num1 || r2.getFoo() != num2))
            {
                setVariablesWorks = false;
                System.out.println("Error with getFoo - after setting");
            }
        }

        if(ReduceTheCode.a(0) != 12)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(0) = ")).append(ReduceTheCode.a(0)).append(" not 12").toString());
        else
        if(ReduceTheCode.a(1) != 13)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(1) = ")).append(ReduceTheCode.a(1)).append(" not 13").toString());
        else
        if(ReduceTheCode.a(2) != 14)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(2) = ")).append(ReduceTheCode.a(2)).append(" not 14").toString());
        else
        if(ReduceTheCode.a(3) != 15)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(3) = ")).append(ReduceTheCode.a(3)).append(" not 15").toString());
        else
        if(ReduceTheCode.a(4) != 16)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(4) = ")).append(ReduceTheCode.a(4)).append(" not 16").toString());
        else
        if(ReduceTheCode.a(5) != 17)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(5) = ")).append(ReduceTheCode.a(5)).append(" not 17").toString());
        else
        if(ReduceTheCode.a(6) != 18)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(6) = ")).append(ReduceTheCode.a(6)).append(" not 18").toString());
        else
        if(ReduceTheCode.a(7) != 19)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(7) = ")).append(ReduceTheCode.a(7)).append(" not 19").toString());
        else
        if(ReduceTheCode.a(8) != 20)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(8) = ")).append(ReduceTheCode.a(8)).append(" not 20").toString());
        else
        if(ReduceTheCode.a(9) != 21)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(9) = ")).append(ReduceTheCode.a(9)).append(" not 21").toString());
        else
        if(ReduceTheCode.a(10) != 22)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(10) = ")).append(ReduceTheCode.a(10)).append(" not 22").toString());
        else
        if(ReduceTheCode.a(11) != 23)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(11) = ")).append(ReduceTheCode.a(11)).append(" not 23").toString());
        else
        if(ReduceTheCode.a(12) != 24)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(12) = ")).append(ReduceTheCode.a(12)).append(" not 24").toString());
        else
        if(ReduceTheCode.a(13) != 25)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(13) = ")).append(ReduceTheCode.a(13)).append(" not 25").toString());
        else
        if(ReduceTheCode.a(14) != 26)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(14) = ")).append(ReduceTheCode.a(14)).append(" not 26").toString());
        else
        if(ReduceTheCode.a(15) != 27)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(15) = ")).append(ReduceTheCode.a(15)).append(" not 27").toString());
        else
        if(ReduceTheCode.a(16) != 28)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(16) = ")).append(ReduceTheCode.a(16)).append(" not 28").toString());
        else
        if(ReduceTheCode.a(17) != 29)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(17) = ")).append(ReduceTheCode.a(17)).append(" not 29").toString());
        else
        if(ReduceTheCode.a(18) != 30)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(18) = ")).append(ReduceTheCode.a(18)).append(" not 30").toString());
        else
        if(ReduceTheCode.a(19) != 31)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(19) = ")).append(ReduceTheCode.a(19)).append(" not 31").toString());
        else
        if(ReduceTheCode.a(20) != 32)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(20) = ")).append(ReduceTheCode.a(20)).append(" not 32").toString());
        else
        if(ReduceTheCode.a(-10) != -1)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(-10) = ")).append(ReduceTheCode.a(-10)).append(" not -1").toString());
        else
        if(ReduceTheCode.a(100) != -1)
            System.out.println((new StringBuilder("Error with ReduceTheCode.a(100) = ")).append(ReduceTheCode.a(100)).append(" not -1").toString());
        if(ReduceTheCode.b(0) != 3493)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(0) = ")).append(ReduceTheCode.b(0)).append(" not 3493").toString());
        else
        if(ReduceTheCode.b(1) != 3011)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(1) = ")).append(ReduceTheCode.b(1)).append(" not 3011").toString());
        else
        if(ReduceTheCode.b(2) != 6881)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(2) = ")).append(ReduceTheCode.b(2)).append(" not 6881").toString());
        else
        if(ReduceTheCode.b(3) != 5413)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(3) = ")).append(ReduceTheCode.b(3)).append(" not 5413").toString());
        else
        if(ReduceTheCode.b(4) != 2144)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(4) = ")).append(ReduceTheCode.b(4)).append(" not 2144").toString());
        else
        if(ReduceTheCode.b(5) != 1728)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(5) = ")).append(ReduceTheCode.b(5)).append(" not 1728").toString());
        else
        if(ReduceTheCode.b(6) != 8383)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(6) = ")).append(ReduceTheCode.b(6)).append(" not 8383").toString());
        else
        if(ReduceTheCode.b(7) != 2970)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(7) = ")).append(ReduceTheCode.b(7)).append(" not 2970").toString());
        else
        if(ReduceTheCode.b(8) != 8226)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(8) = ")).append(ReduceTheCode.b(8)).append(" not 8226").toString());
        else
        if(ReduceTheCode.b(9) != 2396)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(9) = ")).append(ReduceTheCode.b(9)).append(" not 2396").toString());
        else
        if(ReduceTheCode.b(10) != 4106)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(10) = ")).append(ReduceTheCode.b(10)).append(" not 4106").toString());
        else
        if(ReduceTheCode.b(11) != 9201)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(11) = ")).append(ReduceTheCode.b(11)).append(" not 9201").toString());
        else
        if(ReduceTheCode.b(12) != 9582)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(12) = ")).append(ReduceTheCode.b(12)).append(" not 9582").toString());
        else
        if(ReduceTheCode.b(13) != 7412)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(13) = ")).append(ReduceTheCode.b(13)).append(" not 7412").toString());
        else
        if(ReduceTheCode.b(14) != 4091)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(14) = ")).append(ReduceTheCode.b(14)).append(" not 4091").toString());
        else
        if(ReduceTheCode.b(15) != 7291)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(15) = ")).append(ReduceTheCode.b(15)).append(" not 7291").toString());
        else
        if(ReduceTheCode.b(16) != 1747)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(16) = ")).append(ReduceTheCode.b(16)).append(" not 1747").toString());
        else
        if(ReduceTheCode.b(17) != 9922)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(17) = ")).append(ReduceTheCode.b(17)).append(" not 9922").toString());
        else
        if(ReduceTheCode.b(18) != 4647)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(18) = ")).append(ReduceTheCode.b(18)).append(" not 4647").toString());
        else
        if(ReduceTheCode.b(19) != 6070)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(19) = ")).append(ReduceTheCode.b(19)).append(" not 6070").toString());
        else
        if(ReduceTheCode.b(20) != 9946)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(20) = ")).append(ReduceTheCode.b(20)).append(" not 9946").toString());
        else
        if(ReduceTheCode.b(-10) != -1)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(-10) = ")).append(ReduceTheCode.b(-10)).append(" not -1").toString());
        else
        if(ReduceTheCode.b(100) != -1)
            System.out.println((new StringBuilder("Error with ReduceTheCode.b(100) = ")).append(ReduceTheCode.b(100)).append(" not -1").toString());
        i = 0;
        ReduceTheCode.c(0);
        if((i += 7221) != 7221)
            System.out.println("Error with ReduceTheCode.c(0) not 3493");
        i = 5084;
        ReduceTheCode.c(1);
        if(i != 5084)
            System.out.println("Error with ReduceTheCode.c(1) not 3011");
        i = 9790;
        ReduceTheCode.c(2);
        if(i != 9790)
            System.out.println("Error with ReduceTheCode.c(2) not 6881");
        i = 7601;
        ReduceTheCode.c(3);
        if(i != 7601)
            System.out.println("Error with ReduceTheCode.c(3) not 5413");
        i = 2951;
        ReduceTheCode.c(4);
        if(i != 2951)
            System.out.println("Error with ReduceTheCode.c(4) not 2144");
        i = 1854;
        ReduceTheCode.c(5);
        if(i != 1854)
            System.out.println("Error with ReduceTheCode.c(5) not 1728");
        i = 1372;
        ReduceTheCode.c(6);
        if(i != 1372)
            System.out.println("Error with ReduceTheCode.c(6) not 8383");
        i = 5874;
        ReduceTheCode.c(7);
        if(i != 5874)
            System.out.println("Error with ReduceTheCode.c(7) not 2970");
        i = 2996;
        ReduceTheCode.c(8);
        if(i != 2996)
            System.out.println("Error with ReduceTheCode.c(8) not 8226");
        i = 5345;
        ReduceTheCode.c(9);
        if(i != 5345)
            System.out.println("Error with ReduceTheCode.c(9) not 2396");
        i = 5358;
        ReduceTheCode.c(10);
        if(i != 5358)
            System.out.println("Error with ReduceTheCode.c(10) not 4106");
        i = 4542;
        ReduceTheCode.c(11);
        if(i != 4542)
            System.out.println("Error with ReduceTheCode.c(11) not 9201");
        i = 3103;
        ReduceTheCode.c(12);
        if(i != 3103)
            System.out.println("Error with ReduceTheCode.c(12) not 9582");
        i = 2730;
        ReduceTheCode.c(13);
        if(i != 2730)
            System.out.println("Error with ReduceTheCode.c(13) not 7412");
        i = 1972;
        ReduceTheCode.c(14);
        if(i != 1972)
            System.out.println("Error with ReduceTheCode.c(14) not 4091");
        i = 2703;
        ReduceTheCode.c(15);
        if(i != 2703)
            System.out.println("Error with ReduceTheCode.c(15) not 7291");
        i = 1661;
        ReduceTheCode.c(16);
        if(i != 1661)
            System.out.println("Error with ReduceTheCode.c(16) not 1747");
        i = 6783;
        ReduceTheCode.c(17);
        if(i != 6783)
            System.out.println("Error with ReduceTheCode.c(17) not 9922");
        i = 4094;
        ReduceTheCode.c(18);
        if(i != 4094)
            System.out.println("Error with ReduceTheCode.c(18) not 4647");
        i = 3128;
        ReduceTheCode.c(19);
        if(i != 3128)
            System.out.println("Error with ReduceTheCode.c(19) not 6070");
        i = -1;
        ReduceTheCode.c(-10);
        if(i != -1)
            System.out.println("Error with ReduceTheCode.c(-10) not -1");
        i = -1;
        ReduceTheCode.c(100);
        if(i != -1)
            System.out.println("Error with ReduceTheCode.c(100) not -1");
        System.out.println("Testing completed");
    }
}
