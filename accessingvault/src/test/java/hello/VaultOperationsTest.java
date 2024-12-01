package hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

@SpringBootTest
public class VaultOperationsTest {

	@Autowired
	private VaultOperations vaultOperations;

	@Test
	void readShouldRetrieveVaultData() {

		VaultResponse response = this.vaultOperations.opsForKeyValue("secret", KeyValueBackend.KV_2).get("github");

		assertThat(response.getData()).containsEntry("github.oauth2.key", "foobar");
	}

	@Test
	void writeShouldStoreVaultData() {

		Map<String, String> credentials = new HashMap<>();
		credentials.put("username", "john");
		credentials.put("password", "doe");

		VaultKeyValueOperations kv = this.vaultOperations.opsForKeyValue("secret", KeyValueBackend.KV_2);
		kv.put("secret/database", credentials);

		VaultResponseSupport<Credentials> mappedCredentials = kv.get("secret/database", Credentials.class);

		assertThat(mappedCredentials.getData().getUsername()).isEqualTo("john");
		assertThat(mappedCredentials.getData().getPassword()).isEqualTo("doe");
	}

	static class Credentials {

		private String username;
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
