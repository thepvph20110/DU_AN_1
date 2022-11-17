package service.Impl;

import domainmodel.PhuPhi;
import enumclass.trangThaiPhuPhi;
import java.util.ArrayList;
import java.util.List;
import modelview.QLPhuPhi;
import repository.IPhuPhiRepository;
import repository.impl.PhuPhiRepositoryImpl;
import service.IPhuPhiService;

public class PhuPhiServiceImpl implements IPhuPhiService {

    private final IPhuPhiRepository repository;
    private List<QLPhuPhi> lstQLPhuPhis;

    public PhuPhiServiceImpl() {
        repository = new PhuPhiRepositoryImpl();
        lstQLPhuPhis = new ArrayList<>();
    }

    @Override
    public List<QLPhuPhi> getAllQLPhuPhis() {
        lstQLPhuPhis.clear();
        var x = repository.getAllPhuPhi();
        for (PhuPhi p : x) {
            lstQLPhuPhis.add(new QLPhuPhi(p.getId(), p.getMaPhuPhi(), p.getTenPhuPhi(), p.getGiaPhuPhi(), p.getMoTa(), p.getTrangThai()));
        }
        return lstQLPhuPhis;
    }

    @Override
    public boolean save(QLPhuPhi qLphuPhi) {
        boolean x = repository.save(new PhuPhi(null, qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return x;
    }

    @Override
    public boolean update(QLPhuPhi qLphuPhi) {
        boolean x = repository.save(new PhuPhi(qLphuPhi.getId(), qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return x;
    }

    @Override
    public boolean delete(QLPhuPhi qLphuPhi) {
        boolean x = repository.delete(new PhuPhi(qLphuPhi.getId(), qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return x;
    }

}
