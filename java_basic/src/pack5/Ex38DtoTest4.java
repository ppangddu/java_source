package pack5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex38DtoTest4 {
    int sudang = 0;
    private ArrayList<Ex38SawonDto> list = new ArrayList<Ex38SawonDto>();

    public void insertData(String[] datas) {
        for (int i = 0; i < datas.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(datas[i], ",");
            int sabun = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();
            int salary = Integer.parseInt(tokenizer.nextToken());
            int year = Integer.parseInt(tokenizer.nextToken());

            Ex38SawonDto dto = new Ex38SawonDto(sabun, salary, year, name);
            list.add(dto);
        }
    }

    public void showData() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        System.out.println("사번\t이름\t기본급\t근무년수\t근속수당\t공제액\t수령액");
        for (int i = 0; i < list.size(); i++) {
            Ex38SawonDto dto = list.get(i);
            int y = year - dto.getYear();
            if (0 < y && y < 3) {
                sudang = 150000;
            } else if (4 < y && y < 8) {
                sudang = 450000;
            } else {
                sudang = 1000000;
            }
            double deductionAmount = (dto.getSalary() + sudang) * 0.5;
            double receivedAmount = (dto.getSalary() + sudang - deductionAmount);

            System.out.println(dto.getSabun() + "\t" + dto.getName() + "\t" + dto.getSalary() +
                  "\t" + y + "\t" +deductionAmount + "\t" + receivedAmount);
        }

    }

        public static void main(String[] args) {
            String[] datas = new String[1];
            datas[0] = "1,강나루,1500000,2005";
            Ex38DtoTest4 test4 = new Ex38DtoTest4();
            test4.insertData(datas);
            test4.showData();

    }
}
