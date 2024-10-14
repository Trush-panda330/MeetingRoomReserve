package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional  //このクラスの各メソッドが自動でトランザクション管理されるようにする
public class RoomService {
	
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	//findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(date)を呼び出す
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(date);
	}
}
