## LDTS - Space Invaders

The world is currently being invaded by some evil and dirty-minded aliens.
You are the chosen one who will have to single-handedly destroy these unworldly creatures in order to keep the Earth safe.

This game was developed by *Duarte Lagoela* (*up202205629@up.pt*), *Miguel Fernandes* (*up202207547@up.pt*) and *Xavier Silva* (*up202207183@up.pt*) within the framework of the curricular unit of LDTS 2023-2024.

### IMPLEMENTED FEATURES
- **Moving** - Pressing *ArrowLeft* and *ArrowRight* will move the PLayerShip
- **Shooting** - The PlayerShip will shoot upwards by pressing the *ArrowUp* key
- **InvaderShips** - There are ships on the top of the terminal who move and shoot randomly; whenever an invader is hit by an ally projectile, it is deleted
- **Barriers** - These will protect both the player and the invaders and get destroyed when hit by a projectile or an asteroid.
- **PowerUps** - For each 100 points acquired, the PlayerShip will be rewarded with stronger shooting types: DoubleShooting(75%) or TripleShooting(25%);
  on the other side, invaders become faster and increase their fire rate for every 4 ships destroyed
- **Respawn** - After killing the last invader, the entire crew respawns and a new set of barriers is randomly generated
- **Score** - Each destroyed InvaderShip increases the score by 10 points
- **Health** - The player starts with 3 lives: loses one each time it gets hit by enemy projectiles and receives one everytime the invaders respawn
- **Leaderboard** - An option on the menu to check all-time best scores
- **Nickname** - When starting a new game, the user is asked to write the name he wants to be displayed on the leaderboard next to his score
- **Instructions** - An option on the menu to learn how to play the game

### DESIGN
#### ARCHITECTURE OF THE GAME

**Problem in Context**

**The Pattern**

To help us design the structure of the project, we used the **Model-View-Controller** pattern.

#### DIFFERENT SHOOTING BEHAVIOURS

**Problem in Context**

The player and the invaders have different shooting behaviours, plus the player can be rewarded with a stronger shooting behaviour by destroying invaders (e.g.: Shooting two projectiles at the same time). Therefore we need to have a way to change his shooting algorithm.


**The Pattern**

To address this functionality, we have decided to apply the **Strategy** pattern because it allows us to separate the ship shooting behaviour from the ship itself and it makes it very easy to change.

**Implementation**

Shooting Behaviours are defined separately from the ships and then assigned to them.

**Consequences**
- Avoids the creation of different Ships for different Shooting algorithms.
- Provides a clear separation of concerns.

#### INVADERS BEHAVIOUR SHOULD CHANGE WHENEVER OTHER INVADER SHIPS ARE DESTROYED

**Problem in Context**

When invaders are destroyed other objects should know about it.

**The Pattern**

In this case, we decided to implement the **Observer** pattern, because the behaviour of an object must change according to events not directly associated with itself.
Whenever an InvaderShip is destroyed, the game controller is notified to accelerate the invader ships and make them shoot more frequently, also the player must be notified to increase his score and possibly change it's shooting behaviour.

**Implementation**

The **invaders** have the observers such as **invader controller** and the **player** as it's observer and notify them when they get destroyed.

**Consequences**

- Subtle connection between the destruction of a ship and the other ships
- Invaders notify observers and it's not their concern on what the other objects do with the notification

#### CREATION OF DIFFERENT PROJECTILES

**Problem in Context**

Shooter functions need to constantly create ally or enemy projectiles.

**The Pattern**

The **Factory** Pattern is chosen to address the problem. The **Factory** Pattern defines an interface for creating an object but leaves the choice of its type to the subclasses, creating instances of objects without specifying their concrete attributes.

**Implementation**

A **Factory** for both ally and enemy projectiles, so the shooter functions don't have to worry about concrete object creation.

**Consequences**

- Differ responsibilities of classes.
- Code encapsulation.

#### GROUPS OF SIMILAR OBJECTS

**Problem in Context**

Similar objects being dealt with individually.

**The Pattern**

To solve this problem we can make use of the **Composite** pattern.

**Implementation**

Group similar objects in a **Group Class** and deal with them in a higher level.

**Consequences**

- Code encapsulation
- Separation of responsibilities


### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

- Duarte Lagoela: 33%
- Miguel Fernandes: 33%
- Xavier Silva: 33%
