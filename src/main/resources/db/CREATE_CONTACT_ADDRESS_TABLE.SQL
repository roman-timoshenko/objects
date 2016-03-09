CREATE TABLE IF NOT EXISTS contact_address (contact_id INT , address_id INT);
ALTER TABLE contact_country ADD FOREIGN KEY (contact_id) REFERENCES contact (id) ON DELETE CASCADE;
ALTER TABLE contact_country ADD FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE;