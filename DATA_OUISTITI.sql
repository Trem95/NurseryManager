use nurserydb;

INSERT INTO baby VALUES (0,"Marcel");
INSERT INTO baby VALUES (0,"Micheline");
INSERT INTO baby VALUES (0,"Paul");
INSERT INTO baby VALUES (0,"Jacques");
INSERT INTO baby VALUES (0,"Hubert");
INSERT INTO baby VALUES (0,"Jeannne");
INSERT INTO baby VALUES (0,"Caroline");
INSERT INTO baby VALUES (0,"Huguette");
INSERT INTO baby VALUES (0,"Natasha");
INSERT INTO baby VALUES (0,"Claude");
INSERT INTO baby VALUES (0,"Olivier");

INSERT INTO observation VALUES (0,"papa","mal dormi",1,"20-02-12","12:00");
INSERT INTO observation VALUES (0,"papa","pas manger",1,"20-12-21","12:00");
INSERT INTO observation VALUES (0,"maman","reveillé tot",3,"20-04-12","12:00");
INSERT INTO observation VALUES (0,"maman","tout vas bien",3,"20-01-30","12:00");
INSERT INTO observation VALUES (0,"tante","mal de tete",5,"21-01-04","12:00");
INSERT INTO observation VALUES (0,"tonton","tout vas bien",6,"20-12-22","12:00");

INSERT INTO paednurse VALUES (0,"Marine","mfrison","Anma280715");
INSERT INTO paednurse VALUES (0,"Gertrude","gfroa","GnJr52");
INSERT INTO paednurse VALUES (0,"Estelle","eraku","ERt2541");

INSERT INTO meal VALUES (0,1,"morceaux","","20-12-23","12:00");
INSERT INTO meal VALUES (0,2,"panade","","20-12-02","12:00");
INSERT INTO meal VALUES (0,5,"lait","grande faim","20-12-10","12:00");
INSERT INTO meal VALUES (0,4,"morceaux","pas envie de manger","20-12-12","12:00");
INSERT INTO meal VALUES (0,3,"panade","","20-12-14","12:00");
INSERT INTO meal VALUES (0,1,"lait","pas bcp mangé","20-12-21","12:00");

INSERT INTO nap VALUES (0,"20-12-21","13:00:00","14:00:00","",1);
INSERT INTO nap VALUES (0,"20-12-21","10:00:00","11:00:00","",1);
INSERT INTO nap VALUES (0,"20-12-21","13:00:00","14:00:00","",3);
INSERT INTO nap VALUES (0,"20-12-21","10:00:00","11:00:00","",3);
INSERT INTO nap VALUES (0,"20-12-21","14:00:00","15:00:00","",2);
INSERT INTO nap VALUES (0,"20-12-21","15:00:00","16:00:00","",6);

INSERT INTO timesheet VALUES (0,"20-12-21","08:00:00","14:00:00",1);
INSERT INTO timesheet VALUES (0,"20-12-21","10:00:00","18:00:00",2);
INSERT INTO timesheet VALUES (0,"20-12-21","07:00:00","16:00:00",3);
INSERT INTO timesheet VALUES (0,"20-12-21","12:00:00","15:00:00",4);
INSERT INTO timesheet VALUES (0,"20-12-21","11:00:00","17:00:00",5);
INSERT INTO timesheet VALUES (0,"20-12-21","07:00:00","12:00:00",6);

