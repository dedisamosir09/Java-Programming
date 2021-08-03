INSERT INTO `roles` (`id`, `role`) VALUES (1, 'ROLE_USER'); 
INSERT INTO `roles` (`id`, `role`) VALUES (2, 'ROLE_ADMIN'); 


-- Password : bcafinanceh8
INSERT INTO `users` (`id`, `first_name`, `last_name`, `mobile_number`, `password`, `username`) VALUES
(1, 'admin', 'bcaf', '087871273564', '$2a$10$3J9PMDWKwN.AXx26E05nQ.XaWRmCiU9Z3GPwuTp2JBKQ1bnKt2vCi', 'admin');


INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

INSERT INTO `agency` (`id`, `code`, `details`, `name`, `user_id`) VALUES
(1, 'Agency-TJ', 'Agency transjakarta', 'Agency transjakarta', 1);

INSERT INTO `stop` (`id`, `code`, `detail`, `name`) VALUES
(1, 'blok-m', 'kota', 'blok m kota'),
(2, 'pluit', 'pinang ranti', 'pluit - pinang ranti');

INSERT INTO `bus` (`id`, `capacity`, `code`, `make`, `agency_id`) VALUES
(1, 80, 'J8', 'koridor 8', 1);

INSERT INTO `trip` (`id`, `fare`, `journey_time`, `agency_id`, `bus_id`, `dest_stop_id`, `source_stop_id`) VALUES
(1, 60, '45 menit', 1, 1, 2, 1);

INSERT INTO `trip_schedule` (`id`, `available_seats`, `trip_date`, `trip_id`) VALUES
(1, 50, '2021-5-31', 1);

INSERT INTO `ticket` (`id`, `cancellable`, `journey_date`, `seat_number`, `user_id`, `trip_schedule_id`) VALUES
(1, b'1', '2021-12-6', 2, 1, 1);

INSERT INTO `trip_shedule_tickets` (`trip_schedule_id`, `ticket_id`) VALUES
(1, 1);