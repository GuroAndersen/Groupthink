package com.example.demo.GameRoom;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomRepository extends JpaRepository<GameRoom, Long> {

    Optional<GameRoom> findByCode(String code);

}
