/*CREATING TABLE BUILDING */

 CREATE TABLE BUILDING (Building_ID Varchar2(20),
Building_Name Varchar2(50),
No_Of_vertices Number,
Building_Shape sdo_Geometry,
constraint building_pk Primary key(Building_ID) );

/* Inserting into USER_SDO_GEOM_METADATA View the details of Building Table*/
 INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('BUILDING', 'Building_Shape',
 MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('xpoint', -100,1000, 0.005), MDSYS.SDO_DIM_ELEMENT('Ypoint',  -100,1000, 0.005) ),NULL); 
  
 /* Creating SPATIAL INDEX On building_shape column of Building table */
CREATE INDEX building_shape_index on BUILDING (Building_Shape) INDEXTYPE IS MDSYS.SPATIAL_INDEX;

 /* CREATING TABLE PHOTOGRAPHER */
 CREATE TABLE PHOTOGRAPHER (Photographer_ID varchar2(5), PHOTOGRAPHER_LOCATION sdo_geometry,
 CONSTRAINT Photographer_pk Primary Key(Photographer_ID));
 
/* Inserting into USER_SDO_GEOM_METADATA View the details of Photographer Table*/
 INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('PHOTOGRAPHER', 'PHOTOGRAPHER_LOCATION',
 MDSYS.SDO_DIM_ARRAY (MDSYS.SDO_DIM_ELEMENT('x_point',0,900, 0.005), MDSYS.SDO_DIM_ELEMENT('y_point', 0,600, 0.005) ),NULL); 

 /* Creating SPATIAL INDEX On Photographer_Location column of PHOTOGRAPHER table */
CREATE INDEX photographer_loc_index on PHOTOGRAPHER (Photographer_Location) INDEXTYPE IS MDSYS.SPATIAL_INDEX;

/* Creating Table PHOTO */
CREATE TABLE PHOTO (Photo_ID varchar2(20), Photographer_ID varchar2(5), Photo_Location sdo_geometry,
CONSTRAINT photo_pk Primary Key(Photo_ID),CONSTRAINT photo_fk Foreign Key(Photographer_ID) 
REFERENCES PHOTOGRAPHER(Photographer_ID) ON DELETE CASCADE);

/* Inserting into USER_SDO_GEOM_METADATA View the details of PHOTO table*/
 INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('PHOTO', 'PHOTO_LOCATION',
 MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('xpoint', -100,900, 0.005), MDSYS.SDO_DIM_ELEMENT('Ypoint',  -100,600, 0.005) ),NULL); 
   
 /* Creating SPATIAL INDEX On PHOTO_LOCATION column of PHOTO table*/
CREATE INDEX photo_location_index on PHOTO (PHOTO_LOCATION) INDEXTYPE IS MDSYS.SPATIAL_INDEX;