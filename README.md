
current state - only tag represents the current resource version.
we discussed a version file in the resource folder that represents the current version - matches the tag
so a change of a generator file will need to be aligned with a chnage in the tag file to have the new dependencies change in the correct resource version
the auto-generated files are stored in auto-generated directory, and it is the one to be pushed to the other repository (regular git commands)
(you can see the withCredentials() func I used in the roni/feat/.... branch in Mamdas)