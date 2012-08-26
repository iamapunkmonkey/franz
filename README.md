#Franz
================================

Franz is a Game Engine/Game builder.

Franz provides the basic structure to allow a developer to build games quickly. All of the back end processing is handled by the framework. The user creates a new IEntityEventListener instance and latches it to the game entity. With this completed the framework calls the user's defined functions for the listener instance and processes what actions the user has programmed.

Franz also allows the user to define multiple Entity Events and give them different names. In the FranzGameObject class there is a variable called _currentEvent that the user can use to set which event the framework should be processing. This is useful should you want to program different events for different levels or different weapons. All the user has to do is program all of the different possible events and then change the _currentEvent variable to point to the event that the user wants at that given time. The framework does the rest.
