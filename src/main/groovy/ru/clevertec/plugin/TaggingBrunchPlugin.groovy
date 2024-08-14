package ru.clevertec.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import ru.clevertec.plugin.task.*

class TaggingBrunchPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('gitInfo', GitInfoExtension)

        project.tasks.register('tagging') {
            setGroup('Git')
            dependsOn('publishTagInOrigin')
        }

        project.tasks.register('publishTagInOrigin', PublishTagInOriginTask) {
            setGroup('Git')
            dependsOn('assignTag')
            onlyIf {
                Task assignTagTask = project.tasks.named('assignTag').get()
                (!assignTagTask.state.skipped && project.gitInfo.isTagAssigned == false)
            }
        }

        project.tasks.register('assignTag', AssignTagTask) {
            setGroup('Git')
            dependsOn('calculateCurrentVersion', 'hasUncommittedChanges')
            onlyIf {
                (project.gitInfo.hasGit == true
                        && project.gitInfo.hasTag == false
                        && project.gitInfo.hasUncommittedChanges == false)
            }
        }

        project.tasks.register('lastCommitHasTag', CheckHasLastCommitTagTask) {
            setGroup('Git')
            dependsOn('checkGit')
            onlyIf {
                (project.gitInfo.hasGit == true)
            }
        }

        project.tasks.register('hasUncommittedChanges', CheckUncommittedChangesTask) {
            setGroup('Git')
            dependsOn('getLastTag', 'calculateCurrentVersion')
            onlyIf {
                (project.gitInfo.hasGit == true)
            }

        }

        project.tasks.register('calculateCurrentVersion', CalculateVersionOfCurrentBuildTask) {
            setGroup('Git')
            dependsOn('getBranchName', 'lastCommitHasTag', 'getLastTag')
            onlyIf {
                (project.gitInfo.hasGit == true && project.gitInfo.hasTag == false)
            }
        }

        project.tasks.register('getLastTag', GetLastTagTask) {
            setGroup('Git')
            dependsOn('checkGit')
            onlyIf {
                (project.gitInfo.hasGit == true)
            }
        }

        project.tasks.register('getBranchName', GetCurrentBranchNameTask) {
            setGroup('Git')
            dependsOn('checkGit')
            onlyIf {
                (project.gitInfo.hasGit == true)
            }
        }

        project.tasks.register('checkGit', CheckGitTask) {
            setGroup('Git')
        }

    }
}
