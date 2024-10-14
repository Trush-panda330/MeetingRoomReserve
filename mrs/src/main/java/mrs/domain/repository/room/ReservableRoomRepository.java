package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;


/*extends JpaRepository<T, ID> 型パラメータに
 * 
 * */
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
List <ReservableRoom> findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(LocalDate localDate);

}
/*
 * 
 * このメソッドを呼び出すとこのようなSQLが実行される
 * 
 * select 
 * 		reservable0_.reserved_date as reserved1_1_,
 * 		reservable0_.room_id as room_id2_1_
 * from 
 * 		reservable_room reservable0_
 * where 
 * 		reservable0_.reserved_date=?
 * order by 
 * 		reservable0_.room_id asc
 * 		*/
