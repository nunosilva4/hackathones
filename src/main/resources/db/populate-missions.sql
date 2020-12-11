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
