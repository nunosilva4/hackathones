DELETE FROM mission;
INSERT INTO mission(TITLE, DESCRIPTION, REPCOST, SUCCESSRATE, REPREWARD, VERSION) VALUES
('When life gives you lemons', 'There is an unattended lemonade stand in the side of the road. There might be loot, this looks like an opportunity.', 0, 0.95, 5, 0),
('Getting to the big leagues', 'You find yourself the chance for the easiest pickpocket of your life. Do you want to rob a blind guy?', 5, 0.85, 10, 0),
('Grand Theft Auto', 'A old car, probably with no alarm, looks like an easy target. Go for it?', 15, 0.8, 25, 0),
('What a rebel', 'Police car stopped at the donut shop. Empty and unlocked. That radio looks good, doesn´t it?', 70, 0.7, 100, 0),
('Lookout, we have a badass', 'Old lady´s house. Might be some goodies. Are you that kind of jerk?', 150, 0.6, 250, 0),
('Notice me senpai', 'Nice car, nice neighbourhood. Take it as souvenir? ', 500, 0.5, 750, 0),
('Mess with the bull', 'Crappy jewelery store in the neighbour city. Why not?', 800, 0.45, 1500, 0),
('Getting serious', 'Police station. Evidence locker. Just getting back what´s mine.', 4000, 0.4, 7500, 0),
('Life is a gamble', 'High stakes poker game at a rival crew turf. Undercover heist?', 10000, 0.35, 25000, 0),
('High risk, high reward', 'Time to wipe out another Crew. Like taking candy from a baby.', 40000, 0.3, 100000, 0);

DELETE FROM crew;
INSERT INTO crew(NAME, VERSION, LOGO, TAG, CREWREP) VALUES
('Aryan Brotherhood', 0, 'https://i.ibb.co/CK69rZ2/aryan-resistance-logo.png', 'notag', 0),
('Los Vagos', 0, 'https://i.ibb.co/cXJ0FJv/los-vagos-crew-logo.png', 'notag', 0),
('Bloods', 0, 'https://i.ibb.co/zZBwbMn/blood-crew-logo.png', 'notag', 0),
('Yakuza', 0, 'https://i.ibb.co/P5ppCVD/yakuza-crew-logo.png', 'notag', 0),
('Yardie', 0, 'https://i.ibb.co/VHsntKf/yardie-crew-logo.png', 'notag', 0);

DELETE FROM avatar;
INSERT INTO avatar(VERSION, IMAGEURL, CREW_ID) VALUES
(0, 'https://i.ibb.co/DV6rQgQ/Yakuza-F-1.png', 4),
(0, 'https://i.ibb.co/qkFg3Tn/Yakuza-F-2.png', 4),
(0, 'https://i.ibb.co/M69TJ0w/Yakuza-F-3.png', 4),
(0, 'https://i.ibb.co/Rz02wdr/Yakuza-F-4.png', 4),
(0, 'https://i.ibb.co/SPm9wJR/Yakuza-F-5.png', 4),
(0, 'https://i.ibb.co/R7NQCRJ/Yakuza-M-1.png', 4),
(0, 'https://i.ibb.co/J7P2fh2/Yakuza-M-2.png', 4),
(0, 'https://i.ibb.co/wJ9XM72/Yakuza-M-3.png', 4),
(0, 'https://i.ibb.co/XJ3JFx9/Yakuza-M-4.png', 4),
(0, 'https://i.ibb.co/Hn6znbd/Yakuza-M-5.png', 4),
(0, 'https://i.ibb.co/tQRh2zF/LV-Female-1.png', 2),
(0, 'https://i.ibb.co/5WtHHZL/LV-Female-2.png', 2),
(0, 'https://i.ibb.co/Nsn83pp/LV-Female-3.png', 2),
(0, 'https://i.ibb.co/Svb273x/LV-Male-1.png', 2),
(0, 'https://i.ibb.co/S097HG3/LV-Male-2.png', 2),
(0, 'https://i.ibb.co/GPpTFfc/Yardie-Female-1.png', 5),
(0, 'https://i.ibb.co/3zTF2d7/Yardie-Female-2.png', 5),
(0, 'https://i.ibb.co/YbT7Jm2/Yardie-Male-1.png', 5),
(0, 'https://i.ibb.co/RP8cyqf/Yardie-Male-2.png', 5),
(0, 'https://i.ibb.co/cJxBmGc/Bloods-Female-1.png', 3),
(0, 'https://i.ibb.co/C5vyKL1/Bloods-Female-2.png', 3),
(0, 'https://i.ibb.co/GsB53Kz/Bloods-Male-1.png', 3),
(0, 'https://i.ibb.co/MGFMMgt/Bloods-Male-2.png', 3),
(0, 'https://i.ibb.co/WW3Ys5n/AR-Female-1.png', 1),
(0, 'https://i.ibb.co/n6dsVW1/AR-Female-2.png', 1),
(0, 'https://i.ibb.co/DK5mWg3/AR-Male-1.png', 1),
(0, 'https://i.ibb.co/NTKKzYQ/AR-Male-2.png', 1);
