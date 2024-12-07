package com.medsync.Medsync_booking.Service;

import java.util.List;

import com.medsync.Medsync_booking.Model.DocterAdmin;

public interface DocterAdminService {
    DocterAdmin createDocterAdmin(DocterAdmin docterAdmin);
    DocterAdmin getDocterAdminById(String id);
    List<DocterAdmin> getAllDocterAdmin();
    DocterAdmin updateDocterAdmin(String id, DocterAdmin docterAdmin);
    void deleteDocterAdmin(String id);
}
