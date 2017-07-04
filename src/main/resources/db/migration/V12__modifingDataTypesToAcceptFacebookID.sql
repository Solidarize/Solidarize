ALTER TABLE solidarize_user DROP COLUMN id;
ALTER TABLE solidarize_user ADD COLUMN id BIGINT;

ALTER TABLE event_user DROP COLUMN solidarize_user;
ALTER TABLE event_user ADD COLUMN solidarize_user BIGINT;