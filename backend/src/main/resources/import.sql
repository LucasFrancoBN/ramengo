INSERT INTO tb_broth (id, image_inactive, image_active, name, description, price) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', './assets/salt/inactive.svg', './assets/salt/active.svg', 'Salt', 'Simple like the seawater, nothing more', 10.0);
INSERT INTO tb_broth (id, image_inactive, image_active, name, description, price) VALUES ('cb9cb050-e808-4aeb-ac3b-a17a5a2259d2', './assets/shoyu/inactive.svg', './assets/shoyu/active.svg', 'Shoyu', 'The good old and traditional soy sauce', 10.0);
INSERT INTO tb_broth (id, image_inactive, image_active, name, description, price) VALUES ('91eb874e-3b4d-423b-b459-30de2fbdedc5', './assets/miso/inactive.svg', './assets/miso/active.svg', 'Miso', 'Simple like the seawater, nothing more', 12.0);


INSERT INTO tb_protein (id, image_inactive, image_active, name, description, price) VALUES ('b0cd9ea6-eb19-4e38-ad54-a7939fef4c44', './assets/chasu/inactive.svg', './assets/chasu/active.svg', 'Chasu', 'A sliced flavourful pork meat with a selection of season vegetables.', 10.0);
INSERT INTO tb_protein (id, image_inactive, image_active, name, description, price) VALUES ('19b6f879-4deb-48f0-bf7b-074bb3563d58', './assets/yasai/inactive.svg', './assets/yasai/active.svg', 'Yasai', 'A delicious vegetarian lamen with a selection of season vegetables.', 10.0);
INSERT INTO tb_protein (id, image_inactive, image_active, name, description, price) VALUES ('95654a0a-9a56-4953-9bf1-4ee8b2e33f31', './assets/karaague/inactive.svg', './assets/karaague/active.svg', 'Karaague', 'Three units of fried chicken, moyashi, ajitama egg and other vegetables.', 12.0);


INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', 'b0cd9ea6-eb19-4e38-ad54-a7939fef4c44', '2024-06-15 20:57:01.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('cb9cb050-e808-4aeb-ac3b-a17a5a2259d2', '19b6f879-4deb-48f0-bf7b-074bb3563d58', '2024-06-15 21:00:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('91eb874e-3b4d-423b-b459-30de2fbdedc5', '95654a0a-9a56-4953-9bf1-4ee8b2e33f31', '2024-06-15 21:05:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', '19b6f879-4deb-48f0-bf7b-074bb3563d58', '2024-06-15 21:10:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('cb9cb050-e808-4aeb-ac3b-a17a5a2259d2', '95654a0a-9a56-4953-9bf1-4ee8b2e33f31', '2024-06-15 21:15:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('91eb874e-3b4d-423b-b459-30de2fbdedc5', 'b0cd9ea6-eb19-4e38-ad54-a7939fef4c44', '2024-06-15 21:20:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', '95654a0a-9a56-4953-9bf1-4ee8b2e33f31', '2024-06-15 21:25:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('cb9cb050-e808-4aeb-ac3b-a17a5a2259d2', 'b0cd9ea6-eb19-4e38-ad54-a7939fef4c44', '2024-06-15 21:30:00.804275+00', 0);
INSERT INTO tb_order_request (broth_id, protein_id, create_at, status) VALUES ('91eb874e-3b4d-423b-b459-30de2fbdedc5', '19b6f879-4deb-48f0-bf7b-074bb3563d58', '2024-06-15 21:35:00.804275+00', 0);

