ALTER TABLE event DROP COLUMN owner;
ALTER TABLE event ADD COLUMN owner INTEGER;
ALTER TABLE event ADD FOREIGN KEY(owner) REFERENCES institution(id);