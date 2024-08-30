
## Introduction

**BeautyChat** is a free, lightweight, and simple chat formatting plugin for Minecraft. It supports popular permission and chat handling plugins such as **LuckPerms**, **GroupManager**, and **Vault**, and provides integration with **PlaceholderAPI** to enhance functionality.

## Features
- **Lightweight and Simple:** Minimalistic design ensures BeautyChat won't burden your server resources.
- **PlaceholderAPI Support:** Seamless integration with PlaceholderAPI to extend placeholder functionalities.
- **Permissions Support:** Compatible with LuckPerms, GroupManager, and Vault for dynamic chat formatting based on user roles.
- **Customizable Chat Format:** Easily define how your chat messages look using placeholders.

## Placeholders

BeautyChat supports a variety of placeholders to customize your chat format:

- **`{message}`** - The message the player has sent.
- **`{username}`** - The username of the player.
- **`{displayname}`** - The display name / nickname of the player.
- **`{prefix}`** - The players highest priority prefix.
- **`{suffix}`** - The players highest priority suffix.
- **`{world}`** - The name of the world the player is currently in.

## Configuration

To configure BeautyChat, modify the `config.yml` file in the plugin's directory.

<details>
  <summary>config.yml</summary>

  ```yml
    # BeautyChat Configuration File.
    # If you have any problems please create a GitHub issue.
    #
    # This plugin supports PlaceholderAPI so if we don't have the placeholder
    # that you need here, you will likely find it there.
    # https://wiki.placeholderapi.com/users/placeholder-list/
    #
    # Placeholders:
    #  {message}     - The message the player has sent.
    #  {username}    - The username of the player.
    #  {displayname} - The display name / nickname of the player.
    #  {prefix}      - The players highest priority prefix.
    #  {suffix}      - The players highest priority suffix.
    #  {world}       - The name of the world the player is currently in.

    chat-format: "{prefix}&r{username}&r: {message}"
  ```

</details>

## Installation
1. **Download BeautyChat:** Get the latest release from the [GitHub Release](https://example.com/esex)
2. **Place in Plugins Folder:** Move the downloaded jar file into your servers `plugins` folder.
3. **Restart Server:** Restart your Minecraft server to load the plugin.

## Support
For any issues, questions, or suggestions, please create an issue on GitHub.
