package com.medsync.Medsync_booking.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.DocterAdmin;
import com.medsync.Medsync_booking.Repositery.DocterAdminRepositery;
import com.medsync.Medsync_booking.Service.DocterAdminService;

@Service
public class DocterAdminServiceImpl implements DocterAdminService{

    @Autowired
    private DocterAdminRepositery docterAdminRepositery;

    @Override
    public DocterAdmin createDocterAdmin(DocterAdmin docterAdmin) {
        return docterAdminRepositery.save(docterAdmin);
    }

    @Override
    public DocterAdmin getDocterAdminById(String id) {
        Optional<DocterAdmin> docterAdmin = docterAdminRepositery.findById(id);
        return docterAdmin.orElse(null);
    }

    @Override
    public List<DocterAdmin> getAllDocterAdmin() {
        return docterAdminRepositery.findAll();
    }

    @Override
    public DocterAdmin updateDocterAdmin(String id, DocterAdmin docterAdmin) {
        if (docterAdminRepositery.existsById(id)) {
            docterAdmin.setDocterID(id);
            return docterAdminRepositery.save(docterAdmin);
        }
        return null;
    }

    @Override
    public void deleteDocterAdmin(String id) {
        docterAdminRepositery.deleteById(id);
    }

}
