package Welfare.WelfareCheck.domain.Facilitie;

import java.util.List;
import java.util.Map;

public interface FacilitieRepository {
    public BusanWelfareFacilitie save(BusanWelfareFacilitie facilitie);
    public BusanWelfareFacilitie findByNum(String num);
    public List<BusanWelfareFacilitie> facilityNameSearch(String searchWord);
    public List<BusanWelfareFacilitie> findAll();
}
