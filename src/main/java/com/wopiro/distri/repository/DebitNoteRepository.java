package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.DebitNote;

public interface DebitNoteRepository extends JpaRepository<DebitNote, Long> {

}