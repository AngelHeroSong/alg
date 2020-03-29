package GenericParadigm;

public class GeneralIntegerImpl implements IGeneral<Integer> {
    @Override
    public Integer getId() {
        return 2;
    }

    public static void main(String[] args) {

        GeneralIntegerImpl generalInteger = new GeneralIntegerImpl();
        System.out.println(generalInteger.getId());
    }
}
