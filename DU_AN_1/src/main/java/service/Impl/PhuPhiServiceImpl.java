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
        var lstPhuPhi = repository.getAllPhuPhi();
        for (PhuPhi phuPhi : lstPhuPhi) {
            lstQLPhuPhis.add(new QLPhuPhi(phuPhi.getId(), phuPhi.getMaPhuPhi(), phuPhi.getTenPhuPhi(), phuPhi.getGiaPhuPhi(), phuPhi.getMoTa(), phuPhi.getTrangThai()));
        }
        return lstQLPhuPhis;
    }

    @Override
    public boolean save(QLPhuPhi qLphuPhi) {
        boolean save = repository.save(new PhuPhi(null, qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return save;
    }

    @Override
    public boolean update(QLPhuPhi qLphuPhi) {
        boolean update = repository.save(new PhuPhi(qLphuPhi.getId(), qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return update;
    }

    @Override
    public boolean delete(QLPhuPhi qLphuPhi) {
        boolean delete = repository.delete(new PhuPhi(qLphuPhi.getId(), qLphuPhi.getMaPhuPhi(), qLphuPhi.getTenPhuPhi(), qLphuPhi.getGiaPhuPhi(), qLphuPhi.getMoTa(), qLphuPhi.getTrangThai()));
        return delete;
    }

}
