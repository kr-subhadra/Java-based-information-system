
DROP INDEX building_shape_index;
DROP INDEX photographer_loc_index;
DROP INDEX photo_location_index;

DROP TABLE BUILDING;
 
delete from USER_SDO_GEOM_METADATA m WHERE m.table_name = 'BUILDING' AND m.column_name = 'BUILDING_SHAPE';

drop table PHOTO;

delete from USER_SDO_GEOM_METADATA m WHERE m.table_name = 'PHOTO' AND m.column_name = 'PHOTO_LOCATION';

drop table PHOTOGRAPHER;

delete from USER_SDO_GEOM_METADATA m WHERE m.table_name = 'PHOTOGRAPHER' AND m.column_name = 'PHOTOGRAPHER_LOCATION';
