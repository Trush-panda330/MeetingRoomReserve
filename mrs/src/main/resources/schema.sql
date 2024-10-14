-- Reservation schema for MySQL

-- Drop existing tables to avoid conflicts
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS reservable_room;
DROP TABLE IF EXISTS usr;
DROP TABLE IF EXISTS meeting_room;

-- Create meeting_room table
CREATE TABLE IF NOT EXISTS meeting_room (
  room_id INT AUTO_INCREMENT NOT NULL,
  room_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (room_id)
);

-- Create usr table
CREATE TABLE IF NOT EXISTS usr (
  user_id VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

-- Create reservable_room table
CREATE TABLE IF NOT EXISTS reservable_room (
  reserved_date DATE NOT NULL,
  room_id INT NOT NULL,
  PRIMARY KEY (reserved_date, room_id),
  CONSTRAINT FK_room FOREIGN KEY (room_id) REFERENCES meeting_room(room_id) ON DELETE CASCADE
);
--外部キー: room_idは meeting_room テーブルの room_id を参照しており、
-- 部屋が削除された場合、関連する予約も削除される（ON DELETE CASCADE）。

-- Create reservation table
CREATE TABLE IF NOT EXISTS reservation (
  reservation_id INT AUTO_INCREMENT NOT NULL,
  end_time TIME NOT NULL,
  start_time TIME NOT NULL,
  reserved_date DATE NOT NULL,
  room_id INT NOT NULL,
  user_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (reservation_id),
  CONSTRAINT FK_reservable FOREIGN KEY (reserved_date, room_id) REFERENCES reservable_room(reserved_date, room_id) ON DELETE CASCADE,
  CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES usr(user_id) ON DELETE CASCADE
);
--外部キー: room_idは meeting_room テーブルの room_id を参照しており、
-- 部屋が削除された場合、関連する予約も削除される（ON DELETE CASCADE）。
