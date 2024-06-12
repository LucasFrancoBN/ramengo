INSERT INTO tb_broth (id, image_inactive, image_active, name, description, price) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', 'https://tech.redventures.com.br/icons/salt/inactive.svg', 'https://tech.redventures.com.br/icons/salt/active.svg', 'Salt', 'Simple like the seawater, nothing more', 10.0);

INSERT INTO tb_protein (id, image_inactive, image_active, name, description, price) VALUES ('b0cd9ea6-eb19-4e38-ad54-a7939fef4c44', 'https://tech.redventures.com.br/icons/pork/inactive.svg', 'https://tech.redventures.com.br/icons/pork/active.svg', 'Chasu', 'A sliced flavourful pork meat with a selection of season vegetables.', 10.0);

INSERT INTO tb_order_request (broth_id, protein_id) VALUES ('279abe86-4f75-403d-8730-f66a51b3b9d1', 'b0cd9ea6-eb19-4e38-ad54-a7939fef4c44')

