CREATE TABLE IF NOT EXISTS contact_country (contact_id INT , country_id INT);
ALTER TABLE contact_country ADD FOREIGN KEY (contact_id) REFERENCES contact (id) ON DELETE CASCADE;
ALTER TABLE contact_country ADD FOREIGN KEY (contact_country_id) REFERENCES country (id) ON DELETE CASCADE;