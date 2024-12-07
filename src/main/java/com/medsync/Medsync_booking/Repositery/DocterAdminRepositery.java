package com.medsync.Medsync_booking.Repositery;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.DocterAdmin;

public interface DocterAdminRepositery extends MongoRepository<DocterAdmin,String> {

}
